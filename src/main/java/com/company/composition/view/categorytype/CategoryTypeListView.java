package com.company.composition.view.categorytype;

import com.company.composition.entity.CategoryType;
import com.company.composition.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "categoryTypes", layout = MainView.class)
@ViewController(id = "CategoryType.list")
@ViewDescriptor(path = "category-type-list-view.xml")
@LookupComponent("categoryTypesDataGrid")
@DialogMode(width = "64em")
public class CategoryTypeListView extends StandardListView<CategoryType>
{}