package com.company.composition.view.categorytype;

import com.company.composition.entity.CategoryType;
import com.company.composition.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "categoryTypes/:id", layout = MainView.class)
@ViewController(id = "CategoryType.detail")
@ViewDescriptor(path = "category-type-detail-view.xml")
@EditedEntityContainer("categoryTypeDc")
public class CategoryTypeDetailView extends StandardDetailView<CategoryType>
{}