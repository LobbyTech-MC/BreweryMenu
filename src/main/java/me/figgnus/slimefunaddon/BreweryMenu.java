package me.figgnus.slimefunaddon;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import java.util.ArrayList;
import java.util.List;


public class BreweryMenu extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
        // item that represents group
        ItemStack breweryGroupItem = new CustomItemStack(Material.CAULDRON, "&eBrewery", "", "&aOběvte nádherný svět alkoholu...");
        // Give your Category a unique id.
        NamespacedKey breweryGroupId = new NamespacedKey(this, "brewery_category");
        // creates group
        ItemGroup breweryGroup = new ItemGroup(breweryGroupId, breweryGroupItem);

        //item stacks (needed for creating item)
        SlimefunItemStack skotska_whisky_stack = new SlimefunItemStack("SKOTSKA_WHISKY", Material.POTION, "&eSkotská Whisky");
        configureMeta(skotska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack irska_whisky_stack = new SlimefunItemStack("IRSKA_WHISKY", Material.POTION, "&eIrská Whisky");
        configureMeta(irska_whisky_stack, createNewColor(186,125,84));
        SlimefunItemStack bourbon_stack = new SlimefunItemStack("BOURBON", Material.POTION, "&eBourbon");
        configureMeta(bourbon_stack, createNewColor(186,125,84));
        SlimefunItemStack psenicne_pivo_stack = new SlimefunItemStack("PSENICNE_PIVO", Material.POTION, "&ePšeničné Pivo");
        configureMeta(psenicne_pivo_stack, createNewColor(255,184,77));
        SlimefunItemStack pivo_stack = new SlimefunItemStack("PIVO", Material.POTION, "&ePivo");
        configureMeta(pivo_stack, createNewColor(255,211,51));
        SlimefunItemStack tmavy_lezak_stack = new SlimefunItemStack("TMAVY_LEZAK", Material.POTION, "&eTmavý Ležák");
        configureMeta(tmavy_lezak_stack, createNewColor(101,0,19));
        SlimefunItemStack cervene_vino_stack = new SlimefunItemStack("CERVENE_VINO", Material.POTION, "&eČervené Víno");
        configureMeta(cervene_vino_stack, Color.RED);
        SlimefunItemStack bile_vino_stack = new SlimefunItemStack("BILE_VINO", Material.POTION, "&eBílé Víno");
        configureMeta(bile_vino_stack, Color.YELLOW);
        SlimefunItemStack medovina_stack = new SlimefunItemStack("MEDOVINA", Material.POTION, "&eMedovina");
        configureMeta(medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecna_medovina_stack = new SlimefunItemStack("JABLECNA_MEDOVINA", Material.POTION, "&eJablečná Medovina");
        configureMeta(jablecna_medovina_stack, Color.ORANGE);
        SlimefunItemStack jablecny_most_stack = new SlimefunItemStack("JABLECNY_MOST", Material.POTION, "&eJablečný Mošt");
        configureMeta(jablecny_most_stack, createNewColor(248,104,32));
        SlimefunItemStack jablecny_liker_stack = new SlimefunItemStack("JABLECNY_LIKER", Material.POTION, "&eJablečný Likér");
        configureMeta(jablecny_liker_stack, Color.RED);
        SlimefunItemStack rum_stack = new SlimefunItemStack("RUM", Material.POTION, "&eRum");
        configureMeta(rum_stack, Color.MAROON);
        SlimefunItemStack vodka_stack = new SlimefunItemStack("VODKA", Material.POTION, "&eVodka");
        configureMeta(vodka_stack, Color.WHITE);
        SlimefunItemStack houbova_vodka_stack = new SlimefunItemStack("HOUBOVA_VODKA", Material.POTION, "&eHoubová Vodka");
        configureMeta(houbova_vodka_stack, createNewColor(255,153,153));
        SlimefunItemStack gin_stack = new SlimefunItemStack("GIN", Material.POTION, "&eGin");
        configureMeta(gin_stack, createNewColor(153,221,255));
        SlimefunItemStack tequila_stack = new SlimefunItemStack("TEQUILA", Material.POTION, "&eTequila");
        configureMeta(tequila_stack, createNewColor(245,240,126));
        SlimefunItemStack absinth_stack = new SlimefunItemStack("ABSINTH", Material.POTION, "&eAbsinth");
        configureMeta(absinth_stack, Color.GREEN);
        SlimefunItemStack zeleny_absinth_stack = new SlimefunItemStack("ZELENY_ABSINTH", Material.POTION, "&eZelený Absinth");
        configureMeta(zeleny_absinth_stack, Color.LIME);
        SlimefunItemStack bramborova_polevka_stack = new SlimefunItemStack("BRAMBOROVA_POLEVKA", Material.POTION, "&eBramborová Polévka");
        configureMeta(bramborova_polevka_stack, Color.ORANGE);
        SlimefunItemStack kava_stack = new SlimefunItemStack("KAVA", Material.POTION, "&eKáva");
        configureMeta(kava_stack, Color.BLACK);
        SlimefunItemStack vajecnak_stack = new SlimefunItemStack("VAJECNAK", Material.POTION, "&eVaječňák");
        configureMeta(vajecnak_stack, createNewColor(255,230,128));


        //recipe for items
        ItemStack[] item = {null, null, null, null, null, null, null, null, null};

        ItemStack[] skotska_whisky_recipe = {createRecipeItem("Wheat", 9, Material.WHEAT), createRecipeItem("Yeast", 2, Material.BUNDLE), null, null, null, null, createBarrel("Oak", 10), createClock(4), createBrewingStand(2)};
        ItemStack[] irska_whisky_recipe = {createRecipeItem("Wheat", 8, Material.WHEAT), createRecipeItem("Yeast", 2, Material.BUNDLE), null, null, null, null, createBarrel("Oak", 3), createClock(4), createBrewingStand(3)};
        ItemStack[] bourbon_recipe = {createRecipeItem("Wheat", 4, Material.WHEAT), createRecipeItem("Corn", 5, Material.SUGAR_CANE), createRecipeItem("Yeast", 1, Material.BUNDLE), null, null, null, createBarrel("Oak", 3), createClock(4), createBrewingStand(2)};
        ItemStack[] psenicne_pivo_recipe = {createRecipeItem("Wheat", 3, Material.WHEAT), createRecipeItem("Yeast", 1, Material.BUNDLE), null, null, null, null, createBarrel("Birch", 2), createClock(8), null};
        ItemStack[] pivo_recipe = {createRecipeItem("Wheat", 6, Material.WHEAT), createRecipeItem("Yeast", 2, Material.BUNDLE), null, null, null, null, createBarrel("Jakýkoliv Sud", 3), createClock(8), null};
        ItemStack[] tmavy_lezak_recipe = {createRecipeItem("Wheat", 12, Material.WHEAT), createRecipeItem("Yeast", 1, Material.BUNDLE), null, null, null, null, createBarrel("Dark Oak", 8), createClock(8), null};
        ItemStack[] cervene_vino_recipe = {createRecipeItem("Sweet Berries", 9, Material.SWEET_BERRIES), null, null, null, null, null, createBarrel("Jakýkoliv Sud", 20), createClock(5), null};
        ItemStack[] bile_vino_recipe = {createRecipeItem("Glow Berries", 9, Material.GLOW_BERRIES), null, null, null, null, null, createBarrel("Jakýkoliv Sud", 20), createClock(5), null};
        ItemStack[] medovina_recipe = {createRecipeItem("Honey Bottle", 4, Material.HONEY_BOTTLE), createRecipeItem("Sugar", 2, Material.SUGAR), createRecipeItem("Yeast", 2, Material.BUNDLE), null, null, null, createBarrel("Oak", 4), createClock(3), null};
        ItemStack[] jablecna_medovina_recipe = {createRecipeItem("Honey Bottle", 6, Material.HONEY_BOTTLE), createRecipeItem("Apple", 2, Material.APPLE), createRecipeItem("Yeast", 1, Material.BUNDLE), null, null, null, createBarrel("Oak", 4), createClock(4), null};
        ItemStack[] jablecny_most_recipe = {createRecipeItem("Apple", 14, Material.APPLE), null, null, null, null, null, createBarrel("Jakýkoliv Sud", 3), createClock(7), null};
        ItemStack[] jablecny_liker_recipe = {createRecipeItem("Apple", 12, Material.APPLE), createRecipeItem("Sugar", 3, Material.SUGAR), null, null, null, null, createBarrel("Accacia", 6), createClock(16), createBrewingStand(3)};
        ItemStack[] rum_recipe = {createRecipeItem("Corn", 18, Material.SUGAR_CANE), null, null, null, null, null, createBarrel("Oak", 14), createClock(6), createBrewingStand(2)};
        ItemStack[] vodka_recipe = {createRecipeItem("Potato", 16, Material.POTATO), null, null, null, null, null, null, createClock(15), createBrewingStand(3)};
        ItemStack[] houbova_vodka_recipe = {createRecipeItem("Potato", 14, Material.POTATO), createRecipeItem("Red Mushroom", 3, Material.RED_MUSHROOM), createRecipeItem("Brown Mushroom", 3, Material.BROWN_MUSHROOM), null, null, null, null, createClock(18), createBrewingStand(5)};
        ItemStack[] gin_recipe = {createRecipeItem("Wheat", 9, Material.WHEAT), createRecipeItem("Blue Orchids", 6, Material.BLUE_ORCHID), createRecipeItem("Apple",1, Material.APPLE), null, null, null, null, createClock(6), createBrewingStand(2)};
        ItemStack[] tequila_recipe = {createRecipeItem("Cactus", 8, Material.CACTUS), null, null, null, null, null, createBarrel("Birch", 12), createClock(15), createBrewingStand(2)};
        ItemStack[] absinth_recipe = {createRecipeItem("Short Grass", 15, Material.GRASS), null, null, null, null, null, null, createClock(3), createBrewingStand(6)};
        ItemStack[] zeleny_absinth_recipe = {createRecipeItem("Short Grass", 17, Material.GRASS), createRecipeItem("Poisonous Potato", 2, Material.POISONOUS_POTATO), null, null, null, null, null, createClock(5), createBrewingStand(6)};
        ItemStack[] bramborova_polevka_recipe = {createRecipeItem("Potato", 5, Material.POTATO), createRecipeItem("Short Grass", 3, Material.GRASS), null, null, null, null, null, createClock(3), null};
        ItemStack[] kava_recipe = {createRecipeItem("Cocoa Bean", 12, Material.COCOA_BEANS), createRecipeItem("Milk Bucket", 2, Material.MILK_BUCKET), null, null, null, null, null, createClock(2), null};
        ItemStack[] vajecnak_recipe = {createRecipeItem("Egg", 5, Material.EGG), createRecipeItem("Sugar", 2, Material.SUGAR), createRecipeItem("Milk Bucket", 1, Material.MILK_BUCKET), null, null, null, createBarrel("Jakýkoliv Sud",3), createClock(2), null};

        //recipe type - adds icon of cauldron
        RecipeType CAULDRON = new RecipeType(breweryGroupId, breweryGroupItem);

        //creates items
        SlimefunItem skotska_whisky = new SlimefunItem(breweryGroup, skotska_whisky_stack, CAULDRON, skotska_whisky_recipe);
        SlimefunItem irska_whisky = new SlimefunItem(breweryGroup, irska_whisky_stack, CAULDRON, irska_whisky_recipe);
        SlimefunItem bourbon = new SlimefunItem(breweryGroup, bourbon_stack, CAULDRON, bourbon_recipe);
        SlimefunItem psenicne_pivo = new SlimefunItem(breweryGroup, psenicne_pivo_stack, CAULDRON, psenicne_pivo_recipe);
        SlimefunItem pivo = new SlimefunItem(breweryGroup, pivo_stack, CAULDRON, pivo_recipe);
        SlimefunItem tmavy_lezak = new SlimefunItem(breweryGroup, tmavy_lezak_stack, CAULDRON, tmavy_lezak_recipe);
        SlimefunItem cervene_vino = new SlimefunItem(breweryGroup, cervene_vino_stack, CAULDRON, cervene_vino_recipe);
        SlimefunItem bile_vino = new SlimefunItem(breweryGroup, bile_vino_stack, CAULDRON, bile_vino_recipe);
        SlimefunItem medovina = new SlimefunItem(breweryGroup, medovina_stack, CAULDRON, medovina_recipe);
        SlimefunItem jablecna_medovina = new SlimefunItem(breweryGroup, jablecna_medovina_stack, CAULDRON, jablecna_medovina_recipe);
        SlimefunItem jablecny_most = new SlimefunItem(breweryGroup, jablecny_most_stack, CAULDRON, jablecny_most_recipe);
        SlimefunItem jablecny_liker = new SlimefunItem(breweryGroup, jablecny_liker_stack, CAULDRON, jablecny_liker_recipe);
        SlimefunItem rum = new SlimefunItem(breweryGroup, rum_stack, CAULDRON, rum_recipe);
        SlimefunItem vodka = new SlimefunItem(breweryGroup, vodka_stack, CAULDRON, vodka_recipe);
        SlimefunItem houbova_vodka = new SlimefunItem(breweryGroup, houbova_vodka_stack, CAULDRON, houbova_vodka_recipe);
        SlimefunItem gin = new SlimefunItem(breweryGroup, gin_stack, CAULDRON, gin_recipe);
        SlimefunItem tequila = new SlimefunItem(breweryGroup, tequila_stack, CAULDRON, tequila_recipe);
        SlimefunItem absinth = new SlimefunItem(breweryGroup, absinth_stack, CAULDRON, absinth_recipe);
        SlimefunItem zeleny_absinth = new SlimefunItem(breweryGroup, zeleny_absinth_stack, CAULDRON, zeleny_absinth_recipe);
        SlimefunItem bramborova_polevka = new SlimefunItem(breweryGroup, bramborova_polevka_stack, CAULDRON, bramborova_polevka_recipe);
        SlimefunItem kava = new SlimefunItem(breweryGroup, kava_stack, CAULDRON, kava_recipe);
        SlimefunItem vajecnak = new SlimefunItem(breweryGroup, vajecnak_stack, CAULDRON, vajecnak_recipe);

        //register items
        skotska_whisky.register(this);
        irska_whisky.register(this);
        bourbon.register(this);
        psenicne_pivo.register(this);
        pivo.register(this);
        tmavy_lezak.register(this);
        cervene_vino.register(this);
        bile_vino.register(this);
        medovina.register(this);
        jablecna_medovina.register(this);
        jablecny_most.register(this);
        jablecny_liker.register(this);
        rum.register(this);
        vodka.register(this);
        houbova_vodka.register(this);
        gin.register(this);
        tequila.register(this);
        absinth.register(this);
        zeleny_absinth.register(this);
        bramborova_polevka.register(this);
        kava.register(this);
        vajecnak.register(this);

    }
    private Color createNewColor(int a, int b, int c){
        Color color = Color.fromRGB(a, b, c);
        return color;
    }

    private void configureMeta(SlimefunItemStack item, Color color) {
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setColor(color);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
    }

    private ItemStack createRecipeItem(String name, int amount, Material material){
        ItemStack item = new CustomItemStack(material, "&e" + name);
        item.setAmount(amount);
        return item;
    }

    private ItemStack createClock(int i) {
        List<String > lore = new ArrayList<>();
        lore.add(i + " minut");
        ItemStack clock = new CustomItemStack(Material.CLOCK, "&eDoba Vaření");
        ItemMeta meta = clock.getItemMeta();
        meta.setLore(lore);
        clock.setItemMeta(meta);
        return clock;
    }

    private ItemStack createBrewingStand(int i) {
        List<String> lore = new ArrayList<>();
        lore.add(i + " Krát: ");
        ItemStack brewingStand = new CustomItemStack(Material.BREWING_STAND, "&ePočet Destilace");
        ItemMeta meta = brewingStand.getItemMeta();
        meta.setLore(lore);
        brewingStand.setItemMeta(meta);
        return brewingStand;
    }

    private ItemStack createBarrel(String s, int i) {
        List<String> lore = new ArrayList<>();
        lore.add("Sud: " + s);
        lore.add("Čas: " + i + " let");
        ItemStack barrel = new CustomItemStack(Material.BARREL, "&eTyp Sudu");
        ItemMeta meta = barrel.getItemMeta();
        meta.setLore(lore);
        barrel.setItemMeta(meta);
        return barrel;
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }
    //        PotionMeta swMeta = (PotionMeta) skotska_whisky_stack.getItemMeta();
    //        swMeta.setColor(Color.LIME);
    //        swMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
    //        skotska_whisky_stack.setItemMeta(swMeta);

}
