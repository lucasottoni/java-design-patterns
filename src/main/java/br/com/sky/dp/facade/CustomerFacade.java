package br.com.sky.dp.facade;

import br.com.sky.dp.facade.subsystem.crm.CrmService;
import br.com.sky.dp.facade.subsystem.crm.Customer;
import br.com.sky.dp.facade.subsystem.postal.PostalService;

public class CustomerFacade {

    private PostalService postalService;
    private CrmService crmService;

    public CustomerFacade() {
        this.postalService = new PostalService();
        this.crmService = new CrmService();
    }

    public void setPostalService(PostalService postalService) {
        this.postalService = postalService;
    }

    public void setCrmService(CrmService crmService) {
        this.crmService = crmService;
    }

    public void createCustomer(String name, String postalCode) {
        String city = postalService.findCity(postalCode);
        String state = postalService.findState(postalCode);

        Customer crmCustomer = new Customer(name, postalCode, city, state);
        crmService.saveCustomer(crmCustomer);
    }
}
