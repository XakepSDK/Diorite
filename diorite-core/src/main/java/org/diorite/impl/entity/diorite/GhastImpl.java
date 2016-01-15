package org.diorite.impl.entity.diorite;

import java.util.UUID;

import org.diorite.impl.DioriteCore;
import org.diorite.impl.entity.IGhast;
import org.diorite.impl.entity.meta.EntityMetadata;
import org.diorite.ImmutableLocation;
import org.diorite.entity.EntityType;

class GhastImpl extends MonsterEntityImpl implements IGhast
{
    GhastImpl(final UUID uuid, final DioriteCore core, final int id, final ImmutableLocation location)
    {
        super(uuid, core, id, location);
        this.setBoundingBox(BASE_SIZE.create(this));
    }

    @Override
    protected void createMetadata()
    {
        this.metadata = new EntityMetadata(IGhast.META_KEYS);
    }

    @Override
    public void initMetadata()
    {
        super.initMetadata();
    }

    @Override
    public EntityType getType()
    {
        return EntityType.GHAST;
    }
}
