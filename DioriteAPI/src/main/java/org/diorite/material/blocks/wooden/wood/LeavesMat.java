package org.diorite.material.blocks.wooden.wood;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.inventory.item.BaseItemStack;
import org.diorite.material.Material;
import org.diorite.material.WoodType;
import org.diorite.material.data.drops.PossibleDrops;
import org.diorite.material.data.drops.PossibleRandomlyDrop;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "Leaves" and all its subtypes.
 */
public class LeavesMat extends WoodMat
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final int USED_DATA_VALUES = 24;

    public static final LeavesMat LEAVES_OAK      = new LeavesMat();
    public static final LeavesMat LEAVES_SPRUCE   = new LeavesMat("SPRUCE", WoodType.SPRUCE, false, true);
    public static final LeavesMat LEAVES_BIRCH    = new LeavesMat("BIRCH", WoodType.BIRCH, false, true);
    public static final LeavesMat LEAVES_JUNGLE   = new LeavesMat("JUNGLE", WoodType.JUNGLE, false, true);
    public static final LeavesMat LEAVES_ACACIA   = new Leaves2("ACACIA", WoodType.ACACIA, false, true);
    public static final LeavesMat LEAVES_DARK_OAK = new Leaves2("DARK_OAK", WoodType.DARK_OAK, false, true);

    public static final LeavesMat LEAVES_OAK_NO_DECAY      = new LeavesMat("OAK_NO_DECAY", WoodType.OAK, false, false);
    public static final LeavesMat LEAVES_SPRUCE_NO_DECAY   = new LeavesMat("SPRUCE_NO_DECAY", WoodType.SPRUCE, false, false);
    public static final LeavesMat LEAVES_BIRCH_NO_DECAY    = new LeavesMat("BIRCH_NO_DECAY", WoodType.BIRCH, false, false);
    public static final LeavesMat LEAVES_JUNGLE_NO_DECAY   = new LeavesMat("JUNGLE_NO_DECAY", WoodType.JUNGLE, false, false);
    public static final LeavesMat LEAVES_ACACIA_NO_DECAY   = new Leaves2("ACACIA_NO_DECAY", WoodType.ACACIA, false, false);
    public static final LeavesMat LEAVES_DARK_OAK_NO_DECAY = new Leaves2("DARK_OAK_NO_DECAY", WoodType.DARK_OAK, false, false);

    public static final LeavesMat LEAVES_OAK_CHECK_DECAY      = new LeavesMat("OAK_CHECK_DECAY", WoodType.OAK, true, true);
    public static final LeavesMat LEAVES_SPRUCE_CHECK_DECAY   = new LeavesMat("SPRUCE_CHECK_DECAY", WoodType.SPRUCE, true, true);
    public static final LeavesMat LEAVES_BIRCH_CHECK_DECAY    = new LeavesMat("BIRCH_CHECK_DECAY", WoodType.BIRCH, true, true);
    public static final LeavesMat LEAVES_JUNGLE_CHECK_DECAY   = new LeavesMat("JUNGLE_CHECK_DECAY", WoodType.JUNGLE, true, true);
    public static final LeavesMat LEAVES_ACACIA_CHECK_DECAY   = new Leaves2("ACACIA_CHECK_DECAY", WoodType.ACACIA, true, true);
    public static final LeavesMat LEAVES_DARK_OAK_CHECK_DECAY = new Leaves2("DARK_OAK_CHECK_DECAY", WoodType.DARK_OAK, true, true);

    public static final LeavesMat LEAVES_OAK_NO_DECAY_AND_CHECK      = new LeavesMat("OAK_NO_DECAY_AND_CHECK", WoodType.OAK, true, false);
    public static final LeavesMat LEAVES_SPRUCE_NO_DECAY_AND_CHECK   = new LeavesMat("SPRUCE_NO_DECAY_AND_CHECK", WoodType.SPRUCE, true, false);
    public static final LeavesMat LEAVES_BIRCH_NO_DECAY_AND_CHECK    = new LeavesMat("BIRCH_NO_DECAY_AND_CHECK", WoodType.BIRCH, true, false);
    public static final LeavesMat LEAVES_JUNGLE_NO_DECAY_AND_CHECK   = new LeavesMat("JUNGLE_NO_DECAY_AND_CHECK", WoodType.JUNGLE, true, false);
    public static final LeavesMat LEAVES_ACACIA_NO_DECAY_AND_CHECK   = new Leaves2("ACACIA_NO_DECAY_AND_CHECK", WoodType.ACACIA, true, false);
    public static final LeavesMat LEAVES_DARK_OAK_NO_DECAY_AND_CHECK = new Leaves2("DARK_OAK_NO_DECAY_AND_CHECK", WoodType.DARK_OAK, true, false);

    private static final Map<String, LeavesMat>    byName = new CaseInsensitiveMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<LeavesMat> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR, Byte.MIN_VALUE);

    protected final boolean checkDecay;
    protected final boolean decayable;

    @SuppressWarnings("MagicNumber")
    protected LeavesMat()
    {
        super("LEAVES", 18, "minecraft:leaves", "QAK", (byte) 0x00, WoodType.OAK, 0.2f, 1);
        this.checkDecay = false;
        this.decayable = true;
    }

    @SuppressWarnings("MagicNumber")
    protected LeavesMat(final String enumName, final WoodType type, final boolean checkDecay, final boolean decayable, final float hardness, final float blastResistance)
    {
        super(LEAVES_OAK.name() + (type.isSecondLogID() ? "2" : ""), type.isSecondLogID() ? 161 : 18, LEAVES_OAK.getMinecraftId() + (type.isSecondLogID() ? "2" : ""), enumName, combine(type, checkDecay, decayable), type, hardness, blastResistance);
        this.checkDecay = checkDecay;
        this.decayable = decayable;
    }

    @SuppressWarnings("MagicNumber")
    protected LeavesMat(final String enumName, final WoodType type, final boolean checkDecay, final boolean decayable)
    {
        super(LEAVES_OAK.name() + (type.isSecondLogID() ? "2" : ""), type.isSecondLogID() ? 161 : 18, LEAVES_OAK.getMinecraftId() + (type.isSecondLogID() ? "2" : ""), enumName, combine(type, checkDecay, decayable), type, LEAVES_OAK.getHardness(), LEAVES_OAK.getBlastResistance());
        this.checkDecay = checkDecay;
        this.decayable = decayable;
    }

    protected LeavesMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type, final WoodType woodType, final boolean checkDecay, final boolean decayable, final float hardness, final float blastResistance)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type, woodType, hardness, blastResistance);
        this.checkDecay = checkDecay;
        this.decayable = decayable;
    }

    @Override
    public Material ensureValidInventoryItem()
    {
        return this.getType(this.woodType, false, true);
    }

    public boolean isCheckDecay()
    {
        return this.checkDecay;
    }

    public boolean isDecayable()
    {
        return this.decayable;
    }

    @Override
    public LeavesMat getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public LeavesMat getType(final int id)
    {
        return getByID(id);
    }

    @Override
    public LeavesMat getWoodType(final WoodType woodType)
    {
        return getLeaves(woodType, this.checkDecay, this.decayable);
    }

    @Override
    protected PossibleDrops initPossibleDrops()
    {
        return new PossibleDrops(new PossibleRandomlyDrop(new BaseItemStack(Material.APPLE), 0, 1)); // TODO correct chance for drop
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("checkDecay", this.checkDecay).append("decayable", this.decayable).toString();
    }

    public LeavesMat getCheckDecay(final boolean checkDecay)
    {
        return getLeaves(this.woodType, checkDecay, this.decayable);
    }

    public LeavesMat getDecayable(final boolean decayable)
    {
        return getLeaves(this.woodType, this.checkDecay, decayable);
    }

    public LeavesMat getType(final WoodType woodType, final boolean checkDecay, final boolean decayable)
    {
        return getLeaves(woodType, checkDecay, decayable);
    }

    @SuppressWarnings("MagicNumber")
    protected byte getFixedDataValue()
    {
        return (byte) (this.getType() + ((this.getWoodType().isSecondLogID()) ? 16 : 0));
    }

    private static byte combine(final WoodType type, final boolean checkDecay, final boolean decayable)
    {
        byte result = type.getLogFlag();
        if (! decayable)
        {
            result |= 0b0100;
        }
        if (checkDecay)
        {
            result |= 0b1000;
        }
        return result;
    }

    /**
     * Returns one of Leaves sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of Leaves or null
     */
    public static LeavesMat getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of Leaves sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of Leaves or null
     */
    public static LeavesMat getByEnumName(final String name)
    {
        return byName.get(name);
    }

    @SuppressWarnings("MagicNumber")
    public static LeavesMat getLeaves(final WoodType type, final boolean checkDecay, final boolean decayable)
    {
        return getByID(combine(type, checkDecay, decayable) + (type.isSecondLogID() ? 16 : 0));
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    @SuppressWarnings("MagicNumber")
    public static void register(final LeavesMat element)
    {
        byID.put((byte) (element.getType() + ((element instanceof Leaves2) ? 16 : 0)), element);
        byName.put(element.getTypeName(), element);
    }

    @Override
    public LeavesMat[] types()
    {
        return LeavesMat.leavesTypes();
    }

    /**
     * @return array that contains all sub-types of this block.
     */
    public static LeavesMat[] leavesTypes()
    {
        return byID.values(new LeavesMat[byID.size()]);
    }

    /**
     * Helper class for second leaves ID
     */
    public static class Leaves2 extends LeavesMat
    {
        protected Leaves2(final String enumName, final WoodType type, final boolean checkDecay, final boolean decayable)
        {
            super(enumName, type, checkDecay, decayable);
        }

        protected Leaves2(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type, final WoodType woodType, final boolean checkDecay, final boolean decayable, final float hardness, final float blastResistance)
        {
            super(enumName, id, minecraftId, maxStack, typeName, type, woodType, checkDecay, decayable, hardness, blastResistance);
        }

        @Override
        public LeavesMat getType(final int id)
        {
            return getByID(id);
        }

        @SuppressWarnings("MagicNumber")
        /**
         * Returns one of Leaves sub-type based on sub-id, may return null
         * @param id sub-type id
         * @return sub-type of Leaves or null
         */ public static LeavesMat getByID(final int id)
        {
            return byID.get((byte) (id + 16));
        }
    }

    static
    {
        LeavesMat.register(LEAVES_OAK);
        LeavesMat.register(LEAVES_SPRUCE);
        LeavesMat.register(LEAVES_BIRCH);
        LeavesMat.register(LEAVES_JUNGLE);
        LeavesMat.register(LEAVES_ACACIA);
        LeavesMat.register(LEAVES_DARK_OAK);
        LeavesMat.register(LEAVES_OAK_NO_DECAY);
        LeavesMat.register(LEAVES_SPRUCE_NO_DECAY);
        LeavesMat.register(LEAVES_BIRCH_NO_DECAY);
        LeavesMat.register(LEAVES_JUNGLE_NO_DECAY);
        LeavesMat.register(LEAVES_ACACIA_NO_DECAY);
        LeavesMat.register(LEAVES_DARK_OAK_NO_DECAY);
        LeavesMat.register(LEAVES_OAK_CHECK_DECAY);
        LeavesMat.register(LEAVES_SPRUCE_CHECK_DECAY);
        LeavesMat.register(LEAVES_BIRCH_CHECK_DECAY);
        LeavesMat.register(LEAVES_JUNGLE_CHECK_DECAY);
        LeavesMat.register(LEAVES_ACACIA_CHECK_DECAY);
        LeavesMat.register(LEAVES_DARK_OAK_CHECK_DECAY);
        LeavesMat.register(LEAVES_OAK_NO_DECAY_AND_CHECK);
        LeavesMat.register(LEAVES_SPRUCE_NO_DECAY_AND_CHECK);
        LeavesMat.register(LEAVES_BIRCH_NO_DECAY_AND_CHECK);
        LeavesMat.register(LEAVES_JUNGLE_NO_DECAY_AND_CHECK);
        LeavesMat.register(LEAVES_ACACIA_NO_DECAY_AND_CHECK);
        LeavesMat.register(LEAVES_DARK_OAK_NO_DECAY_AND_CHECK);
    }
}
