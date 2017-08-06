# overview-repo

This library provides **full-featured repository implementation with overview (filtering, ordering and pagination) settings, including support for joins (for SQL)** declared in simple functional manner.
Entity mappers provide metadata about attributes of stored entities, so the repository is able to construct all the queries
based on this metadata. Entity mappers can possibly be used also for other transformations of data objects, outside the scope of this library.

Library has no dependencies except a database-type-specific client API and logging API. Various repository implementations that share the same repository interface can be introduced. For now, these implementations (modules) are available:


 * **[SQL](sql/README.md) - production ready JDBC implementation** of full-featured generic repository.
 * **[Mongo](mongo/README.md) - Mongo DB implementation**. Still work in progress, does not yet support nested documents and arrays of documents.


Look at the modules for further documentation and quick start examples. Do not repeat implementations of repositories! Allow yourself to concentrate on your business logic.
There is plenty of methods already implemented for you: Create, update/partial update, delete, delete by filter, find by id, find by filtering and ordering and pagination settings (overview settings), find all, find by filter only (for convenience), count by filter, aggregate (count, sum, min, max, avg) by filter.

## Generally implemented features
 * Partial update only of some subset of attributes (defined using specified attributes with values or using an update lambda).
 * Support for composite primary keys.
 * Optional maximum length property on attributes.

## Planned features
 * Storage of new immutable versions of entity instead of updates, using supported version flag on an attribute (for now, this can be implemented in a custom way using for e.g. (entityId, version) composite key).
 * Minimal fetch levels configurable on attributes so not every attribute must be loaded (e.g. info, detail).
 * Cooperation with another data processing libraries that can leverage general, yet simple definition of attributes (generated forms, CSV/XLS exports from database, ...).
