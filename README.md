# hazelcast-lab

Hazelcast is an in-memory data grid that suports a number of distributed collections and features.

## Caches

Caches are copies of the data alongside the original source. Caches protect the database from high load and improves the overall performance.

For write-heavy systems, the benefits of caches are insignificant or even none.

### Cache's concepts

- TTL - Time to live -> Time to live of entries in a cache;
- Write throw cache -> Holds entries until they are invalidated by subsequent updates

