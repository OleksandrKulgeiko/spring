package c_test;

import com.kulgeiko.spring_prep.c_test.integrationtesting.AppConfigShoppingCart;
import com.kulgeiko.spring_prep.c_test.integrationtesting.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by akulgeiko on 7/18/2018.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfigShoppingCart.class)
public class ShoppingCartTest {

    @Autowired
    private ShoppingCart shoppingCart;

    @Test
    public void testCheckout() {
        shoppingCart.addItem("Item1", 3);
        shoppingCart.addItem("item2", 5);
        String result = shoppingCart.checkout();
        Assert.assertEquals("2 orders placed", result);
    }
}
