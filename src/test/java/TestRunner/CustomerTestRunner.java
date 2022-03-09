package TestRunner;

import Pages.Customer;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerTestRunner {
    @Test(priority = 0)
    public void doLogin() throws ConfigurationException, IOException {
        Customer customer = new Customer();
        customer.callingCustomerLoginAPI();
    }

    @Test(priority = 1)
    public void getCustomerList() throws IOException {
        Customer customer = new Customer();
        customer.callingCustomerListAPI();
    }

    @Test(priority = 2)
    public void searchCustomer() throws IOException {
        Customer customer = new Customer();
        customer.searchCustomer();
    }

    @Test(priority = 3)
    public void GenerateCustomer() throws IOException, ConfigurationException {
        Customer customer = new Customer();
        customer.GenerateCustomer();

    }

    @Test(priority = 4)
    public void createCustomer() throws IOException {
        Customer customer = new Customer();
        customer.createCustomer();
    }

    @Test(priority = 5)
    public void updateCustomerInfo() throws IOException {
        Customer customer = new Customer();
        customer.updateCustomerInfo();
    }

    @Test(priority = 6)
    public void deleteCustomer() throws IOException {
        Customer customer = new Customer();
        customer.deleteCustomer();
    }
}
