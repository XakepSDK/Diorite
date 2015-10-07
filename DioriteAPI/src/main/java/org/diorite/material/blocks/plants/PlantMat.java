package org.diorite.material.blocks.plants;

import org.diorite.material.BlockMaterialData;

/**
 * Base abstract class for plant-based blocks
 */
public abstract class PlantMat extends BlockMaterialData
{
    protected PlantMat(final String enumName, final int id, final String minecraftId, final String typeName, final byte type, final float hardness, final float blastResistance)
    {
        super(enumName, id, minecraftId, typeName, type, hardness, blastResistance);
    }

    protected PlantMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type, final float hardness, final float blastResistance)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type, hardness, blastResistance);
    }

    @Override
    public abstract PlantMat getType(final int type);

    @Override
    public abstract PlantMat getType(final String type);

    @Override
    public abstract PlantMat[] types();
}
