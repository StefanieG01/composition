package com.company.composition.view.customerorder;

import com.company.composition.entity.CustomerOrder;
import com.company.composition.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "customerOrders", layout = MainView.class)
@ViewController(id = "CustomerOrder.list")
@ViewDescriptor(path = "customer-order-list-view.xml")
@LookupComponent("customerOrdersDataGrid")
@DialogMode(width = "64em")
public class CustomerOrderListView extends StandardListView<CustomerOrder>
{}