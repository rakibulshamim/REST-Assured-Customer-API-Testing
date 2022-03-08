import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;

import java.io.IOException;

public class TestRunner {
    @Test
    public void doLogin() throws ConfigurationException, IOException {
        Customer customer = new Customer();
        customer.callingCustomerLoginAPI();
    }

    @Test
    public void getCustomerList() throws IOException {
        Customer customer = new Customer();
        customer.callingCustomerListAPI();
    }

    @Test
    public void searchCustomer() throws IOException {
        Customer customer = new Customer();
        customer.searchCustomer();
    }

    @Test
    public void GenerateCustomer() throws IOException, ConfigurationException {
        Customer customer = new Customer();
        customer.GenerateCustomer();

    }

    @Test
    public void createCustomer() throws IOException {
        Customer customer = new Customer();
        customer.createCustomer();
    }
}
