# CustomRarity

Allows pack makers to define [Item Rarity](https://minecraft.wiki/w/Rarity) by either NBT or config file. Requires ClothConfig.
Best for use with mods like Legendary Tooltips and Immersive UI. 

### Examples
#### Define by NBT:

```/give @p stick{CustomRarity:Epic}```

This mod also comes with Item Modifiers:
```/item modify entity @p container.0 customrarity:rare```
will modify the item in the first slot of your hotbar

#### Define by config:


NBT has precedence over config, and config has precedence over vanilla rarity value. 