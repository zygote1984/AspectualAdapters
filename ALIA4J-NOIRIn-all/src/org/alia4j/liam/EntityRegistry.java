package org.alia4j.liam;

/**
 * @author Christoph Bockisch
 * @author Andreas Sewe
 */
public final class EntityRegistry {
    
    private EntityRegistry() {}
    
    public synchronized static int storeInstanceAtId(final ManageableInstance instance) {
        if (EntityRegistry.nextId >= EntityRegistry.instances.length) {
            final ManageableInstance[] newInstances =
                            new ManageableInstance[EntityRegistry.nextId + EntityRegistry.INITIAL_SIZE];
            System.arraycopy(EntityRegistry.instances, 0, newInstances, 0, EntityRegistry.instances.length);
            EntityRegistry.instances = newInstances;
        }
        final int instanceId = EntityRegistry.nextId;
        EntityRegistry.instances[instanceId] = instance;
        EntityRegistry.nextId++;
        return instanceId;
    }
    
    private static final int INITIAL_SIZE = 10;
    
    private static ManageableInstance[] instances = new ManageableInstance[EntityRegistry.INITIAL_SIZE];
    
    private static int nextId = 0;
    
    public synchronized static Context getContext(final int id) {
        return (Context) EntityRegistry.instances[id];
    }
    
    public synchronized static AtomicPredicate getAtomicPredicate(final int id) {
        return (AtomicPredicate) EntityRegistry.instances[id];
    }
    
    public synchronized static Action getAction(final int id) {
        return (Action) EntityRegistry.instances[id];
    }
}
