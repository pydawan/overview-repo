/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xbery.overview.mapper;

import org.xbery.overview.Group;
import org.xbery.overview.Order;
import org.xbery.overview.common.Pair;
import org.xbery.overview.common.funs.CollectionFuns;

import java.util.List;
import java.util.function.Function;

/**
 * Auxiliary methods for defining decompositions.
 * @author Radek Beran
 */
public class Decompose {

    private static final Object OBJECT_FILTER = new Object();

    /**
     * Decomposition of filter: Filter can be used directly for left side of join operation.
     * @param <F>
     * @return
     */
    public static <F> Function<F, Pair<F, Object>> filterToIdenticalAndObject() {
        return filterToIdenticalAnd(OBJECT_FILTER);
    }

    /**
     * Decomposition of filter: Filter can be used directly for left side of join operation. Filter for right side is specified.
     * @param <F>
     * @return
     */
    public static <F, G> Function<F, Pair<F, G>> filterToIdenticalAnd(final G rightFilter) {
        return filter -> new Pair<>(filter, rightFilter);
    }

    /**
     * Decomposition of ordering: Ordering can be used directly for left side of join operation. Ordering for right side is specified.
     * @return
     */
    public static Function<List<Order>, Pair<List<Order>, List<Order>>> orderingToIdenticalAnd(final List<Order> rightOrdering) {
        return ordering -> new Pair<>(ordering, rightOrdering);
    }

    /**
     * Decomposition of ordering: Ordering can be used directly for left side of join operation. Ordering for right side is specified.
     * @return
     */
    public static Function<List<Order>, Pair<List<Order>, List<Order>>> orderingToIdenticalAnd(final Order rightOrder) {
        return orderingToIdenticalAnd(CollectionFuns.list(rightOrder));
    }

    /**
     * Decomposition of grouping: Grouping can be used directly for left side of join operation. Grouping for right side is specified.
     * @return
     */
    public static Function<List<Group>, Pair<List<Group>, List<Group>>> groupingToIdenticalAnd(final List<Group> rightGrouping) {
        return grouping -> new Pair<>(grouping, rightGrouping);
    }

    /**
     * Decomposition of grouping: Grouping can be used directly for left side of join operation. Grouping for right side is specified.
     * @return
     */
    public static Function<List<Group>, Pair<List<Group>, List<Group>>> groupingToIdenticalAnd(final Group rightGrouping) {
        return groupingToIdenticalAnd(CollectionFuns.list(rightGrouping));
    }

    /**
     * Decomposition of ordering: Ordering can be used directly for left side of join operation.
     */
    public static Function<List<Order>, Pair<List<Order>, List<Order>>> orderingToIdenticalAndEmpty = ordering -> new Pair<>(ordering, CollectionFuns.emptyList());

    public static Function<List<Order>, Pair<List<Order>, List<Order>>> DEFAULT_ORDERING_DECOMPOSITION = Decompose.orderingToIdenticalAndEmpty;

    /**
     * Decomposition of grouping: Grouping can be used directly for left side of join operation.
     */
    public static Function<List<Group>, Pair<List<Group>, List<Group>>> groupingToIdenticalAndEmpty = grouping -> new Pair<>(grouping, CollectionFuns.emptyList());

    public static Function<List<Group>, Pair<List<Group>, List<Group>>> DEFAULT_GROUPING_DECOMPOSITION = Decompose.groupingToIdenticalAndEmpty;

    private Decompose() {
        throw new AssertionError("Use static members of this class.");
    }
}
