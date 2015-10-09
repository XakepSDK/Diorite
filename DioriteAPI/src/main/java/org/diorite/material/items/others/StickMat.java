package org.diorite.material.items.others;

import java.util.Map;

import org.diorite.material.FuelMat;
import org.diorite.material.ItemMaterialData;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;

import gnu.trove.map.TShortObjectMap;
import gnu.trove.map.hash.TShortObjectHashMap;

@SuppressWarnings("MagicNumber")
public class StickMat extends ItemMaterialData implements FuelMat
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final int USED_DATA_VALUES = 1;

    public static final StickMat STICK = new StickMat();

    private static final Map<String, StickMat>     byName = new CaseInsensitiveMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TShortObjectMap<StickMat> byID   = new TShortObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR, Short.MIN_VALUE);

    protected StickMat()
    {
        super("STICK", 280, "minecraft:stick", "STICK", (short) 0x00);
    }

    protected StickMat(final String enumName, final int id, final String minecraftId, final String typeName, final short type)
    {
        super(enumName, id, minecraftId, typeName, type);
    }

    protected StickMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final short type)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type);
    }

    @Override
    public StickMat getType(final int type)
    {
        return getByID(type);
    }

    @Override
    public StickMat getType(final String type)
    {
        return getByEnumName(type);
    }

    @Override
    public int getFuelPower()
    {
        return 500;
    }

    /**
     * Returns one of Stick sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of Stick or null
     */
    public static StickMat getByID(final int id)
    {
        return byID.get((short) id);
    }

    /**
     * Returns one of Stick sub-type based on name (selected by diorite team), may return null
     * If item contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of Stick or null
     */
    public static StickMat getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final StickMat element)
    {
        byID.put(element.getType(), element);
        byName.put(element.getTypeName(), element);
    }

    @Override
    public StickMat[] types()
    {
        return StickMat.stickTypes();
    }

    /**
     * @return array that contains all sub-types of this item.
     */
    public static StickMat[] stickTypes()
    {
        return byID.values(new StickMat[byID.size()]);
    }

    static
    {
        StickMat.register(STICK);
    }
}

