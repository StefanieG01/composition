package com.company.composition.view.orderproduct;

import com.company.composition.entity.OrderProduct;
import com.company.composition.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "orderProducts/:id", layout = MainView.class)
@ViewController(id = "OrderProduct.detail")
@ViewDescriptor(path = "order-product-detail-view.xml")
@EditedEntityContainer("orderProductDc")
public class OrderProductDetailView extends StandardDetailView<OrderProduct>
{}