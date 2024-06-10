package info.partonetrain.customrarity;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Customrarity.MOD_ID)
public class CustomrarityConfig implements ConfigData {
    @Comment("Item IDs set to common rarity (white text)")
    public String[] commons = new String[]{"minecraft:debug_stick"};
    @Comment("Item IDs set to uncommon rarity (yellow text)")
    public String[] uncommons = new String[]{};
    @Comment("Item IDs set to rare rarity (aqua text)")
    public String[] rares = new String[]{};
    @Comment("Item IDs set to epic rarity (magenta text)")
    public String[] epics = new String[]{};

}
