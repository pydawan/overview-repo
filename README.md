# ETN-overview

The library ensures **loading of data with filtering, ordering and pagination settings**.
It contains **full-featured repository** which can load objects using this filtering, ordering and pagination settings,
create, update and delete database entities, only with metadata provided by an entity mapper. Library uses plain JDBC and has no dependencies (except the logging api).
Various repository implementations can be introduced.

Basic repository implementation uses an **entity mapper** which serves all entity attributes metadata, so the repository is able to construct all the queries
based on this metadata. Entity mappers can possibly be used also for other transformations of data objects, outside scope of this library.  

## Planned features
 * Composition of mappers (joins) to allow fetching of 1:0..1 or 1:1 related pageable records with no effort (can be automatized).
 * Storage of new immutable versions of entity instead of updates using version flag on an attribute.
 * CREATE TABLE SQL generated from entity mapper.
 * Cooperation with another data processing libraries that can leverage general, yet simple definition of attributes (generated forms, XLS report from database, ...).

## Running tests

gradlew clean test

## Publishing artifact

gradlew clean uploadArchives

## Releasing artifact

* Increase version in gradle.properties
* gradlew clean release
