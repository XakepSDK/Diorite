package org.diorite.material.items.block.door;

import org.diorite.material.WoodType;
import org.diorite.utils.collections.maps.SimpleEnumMap;

@SuppressWarnings("ClassHasNoToStringMethod")
public abstract class WoodenDoorItemMat extends DoorItemMat
{
    protected final WoodType woodType;

    protected WoodenDoorItemMat(final String enumName, final int id, final String minecraftId, final String typeName, final short type, final WoodType woodType)
    {
        super(enumName, id, minecraftId, typeName, type);
        this.woodType = woodType;
    }

    protected WoodenDoorItemMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final short type, final WoodType woodType)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type);
        this.woodType = woodType;
    }

    private static final SimpleEnumMap<WoodType, WoodenDoorItemMat> types = new SimpleEnumMap<>(6, SMALL_LOAD_FACTOR);

    /**
     * Returns wood type of this door.
     *
     * @return wood type of this door.
     */
    public WoodType getWoodType()
    {
        return this.woodType;
    }

    /**
     * Returns doors made of selected wood type.
     *
     * @param woodType type of wood.
     *
     * @return doors made of selected wood type.
     */
    public WoodenDoorItemMat getWoodType(final WoodType woodType)
    {
        return types.get(woodType);
    }

    @Override
    public abstract WoodenDoorItemMat getType(final int type);

    @Override
    public abstract WoodenDoorItemMat getType(final String type);

    @Override
    public abstract WoodenDoorItemMat[] types();

    /**
     * Returns sub-type of {@link WoodenDoorItemMat}, based on {@link WoodType}.
     *
     * @param woodType {@link WoodType} of WoodenFence
     *
     * @return sub-type of {@link WoodenDoorItemMat}.
     */
    public static WoodenDoorItemMat getWoodenDoorItem(final WoodType woodType)
    {
        return types.get(woodType);
    }

    /**
     * Register new wood type to one of door items, like OAK to OAK_DOOR_ITEM.
     *
     * @param type type of wood.
     * @param mat  fence material.
     */
    public static void registerWoodType(final WoodType type, final WoodenDoorItemMat mat)
    {
        types.put(type, mat);
    }

    static
    {
        registerWoodType(WoodType.OAK, OAK_DOOR_ITEM);
        registerWoodType(WoodType.SPRUCE, SPRUCE_DOOR_ITEM);
        registerWoodType(WoodType.BIRCH, BIRCH_DOOR_ITEM);
        registerWoodType(WoodType.JUNGLE, JUNGLE_DOOR_ITEM);
        registerWoodType(WoodType.ACACIA, ACACIA_DOOR_ITEM);
        registerWoodType(WoodType.DARK_OAK, DARK_OAK_DOOR_ITEM);
    }
}
