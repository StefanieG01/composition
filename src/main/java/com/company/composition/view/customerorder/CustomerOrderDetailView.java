package com.company.composition.view.customerorder;

import com.company.composition.entity.Customer;
import com.company.composition.entity.CustomerOrder;
import com.company.composition.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.view.*;

@Route(value = "customerOrders/:id", layout = MainView.class)
@ViewController(id = "CustomerOrder.detail")
@ViewDescriptor(path = "customer-order-detail-view.xml")
@EditedEntityContainer("customerOrderDc")
public class CustomerOrderDetailView extends StandardDetailView<CustomerOrder>
{
}