package org.diorite.impl.entity.diorite;

import java.util.UUID;

import org.diorite.impl.DioriteCore;
import org.diorite.impl.entity.IAbstractArrow;
import org.diorite.impl.entity.meta.EntityMetadata;
import org.diorite.impl.entity.meta.entry.EntityMetadataByteEntry;
import org.diorite.ImmutableLocation;

abstract class AbstractArrowImpl extends ProjectileImpl implements IAbstractArrow
{
    AbstractArrowImpl(final UUID uuid, final DioriteCore core, final int id, final ImmutableLocation location)
    {
        super(uuid, core, id, location);
    }

    @Override
    protected void createMetadata()
    {
        this.metadata = new EntityMetadata(IAbstractArrow.META_KEYS);
    }

    @Override
    public void initMetadata()
    {
        super.initMetadata();
        this.getMetadata().add(new EntityMetadataByteEntry(META_KEY_ARROW_IS_CRITICAL, 0));
    }

    @Override
    public boolean isCritical()
    {
        return this.metadata.getBoolean(META_KEY_ARROW_IS_CRITICAL);
    }

    @Override
    public void setCritical(final boolean critical)
    {
        this.metadata.setBoolean(META_KEY_ARROW_IS_CRITICAL, critical);
    }
}
