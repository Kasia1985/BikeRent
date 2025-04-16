package pl.javastart.bikerent;


import org.springframework.data.repository.CrudRepository;

interface BikeRepository extends CrudRepository<Bike,Long> {

    /*private final EntityManager entityManager;

    public BikeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Bike bike){
            entityManager.persist(bike);
    }

    public Optional<Bike> findById(Long id){
        return Optional.ofNullable(entityManager.find(Bike.class, id));
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    */

        //We pass a detached entity object; the merge method
        // links the entity with the persistence context,
        // meaning it returns a managed instance.
        // This managed object can then be removed.//
    /* @Transactional
    public void delete(Bike bike){
        Bike mergedEntity = entityManager.merge(bike);
        entityManager.remove(bike);
    }
    */

}
