package com.company.composition.view.productcategory;

import com.company.composition.entity.ProductCategory;
import com.company.composition.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "productCategories", layout = MainView.class)
@ViewController(id = "ProductCategory.list")
@ViewDescriptor(path = "product-category-list-view.xml")
@LookupComponent("productCategoriesDataGrid")
@DialogMode(width = "64em")
public class ProductCategoryListView extends StandardListView<ProductCategory>
{}