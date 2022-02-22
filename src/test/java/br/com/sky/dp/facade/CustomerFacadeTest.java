package br.com.sky.dp.facade;

import br.com.sky.dp.facade.subsystem.crm.CrmService;
import br.com.sky.dp.facade.subsystem.crm.Customer;
import br.com.sky.dp.facade.subsystem.postal.PostalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class CustomerFacadeTest {

    @Test
    public void createCustomer() {
        //given
        CrmService crmService = Mockito.mock(CrmService.class);
        PostalService postalService = Mockito.mock(PostalService.class);

        CustomerFacade customerFacade = new CustomerFacade();
        customerFacade.setCrmService(crmService);
        customerFacade.setPostalService(postalService);

        String postalCode = "40456789";
        String name = "Lucas";

        // when
        Mockito.when(postalService.findCity(postalCode)).thenReturn("Paranavaí");
        Mockito.when(postalService.findState(postalCode)).thenReturn("PR");

        customerFacade.createCustomer(name, postalCode);

        // then
        verify(postalService).findCity(postalCode);
        verify(postalService).findState(postalCode);
        verify(crmService).saveCustomer(new Customer(name, postalCode, "Paranavaí", "PR"));
    }
}
