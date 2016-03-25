package com.carl.resale.ui.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 1886133933L;

    public static final QCategory category = new QCategory("category");

    public final StringPath business = createString("business");

    public final StringPath code = createString("code");

    public final StringPath cssName = createString("cssName");

    public final NumberPath<Integer> goodsCount = createNumber("goodsCount", Integer.class);

    public final ComparablePath<org.bson.types.ObjectId> id = createComparable("id", org.bson.types.ObjectId.class);

    public final ComparablePath<org.bson.types.ObjectId> imageId = createComparable("imageId", org.bson.types.ObjectId.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> order = createNumber("order", Integer.class);

    public final ListPath<SpecificType, SimplePath<SpecificType>> specTypes = this.<SpecificType, SimplePath<SpecificType>>createList("specTypes", SpecificType.class, SimplePath.class, PathInits.DIRECT2);

    public final SimplePath<State> state = createSimple("state", State.class);

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

