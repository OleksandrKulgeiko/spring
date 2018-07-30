package com.kulgeiko.spring_prep.d_data.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

public class EmployeeDao {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // RowMapper
    public List<Employee> getAllEmployeesRowMapper(){
        return template.query("SELECT EMPNO, name, email from EMP", new RowMapper<Employee>(){
            @Override
            public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                return e;
            }
        });
    }

    // ResultSetExtractor
    public List<Employee> getAllEmployees(){
        return template.query("SELECT EMPNO, name, email from EMP", new ResultSetExtractor<List<Employee>>(){
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Employee> list=new ArrayList<Employee>();
                while(rs.next()){
                    Employee e=new Employee();
                    e.setId(rs.getInt(1));
                    e.setName(rs.getString(2));
                    e.setEmail(rs.getString(3));
                    list.add(e);
                }
                return list;
            }
        });
    }


    // RowCallbackHandler
    public void plainSelect() {
        template.execute(new StatementCallback<ResultSet>() {
            public ResultSet doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet rs = statement.executeQuery("SELECT * FROM EMP");
                RowCallbackHandler handler = new RowCallbackHandler() {
                    public void processRow(ResultSet resultSet) throws SQLException {
                        while (resultSet.next()) {
                            System.out.println(resultSet.getObject(1) + "," + resultSet.getObject(3));
                        }
                    }
                };
                handler.processRow(rs);
                return rs;
            }
        });
    }


}
