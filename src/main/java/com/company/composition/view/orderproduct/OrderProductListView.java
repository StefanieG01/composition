package com.company.composition.view.orderproduct;

import com.company.composition.entity.OrderProduct;
import com.company.composition.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "orderProducts", layout = MainView.class)
@ViewController(id = "OrderProduct.list")
@ViewDescriptor(path = "order-product-list-view.xml")
@LookupComponent("orderProductsDataGrid")
@DialogMode(width = "64em")
public class OrderProductListView extends StandardListView<OrderProduct>
{}