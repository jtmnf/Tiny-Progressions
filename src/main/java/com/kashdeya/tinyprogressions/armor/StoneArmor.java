package com.kashdeya.tinyprogressions.armor;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.kashdeya.tinyprogressions.inits.TechArmor;
import com.kashdeya.tinyprogressions.main.tinyprogressions;

public class StoneArmor extends ItemArmor {
	
	public StoneArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlotIn) {
		super(material, renderIndex, equipmentSlotIn);
		this.maxStackSize = 1;
		this.setCreativeTab(tinyprogressions.tabTP);
	}
	
	/**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = new ItemStack(Blocks.STONE, 1, 0);
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }
    
    @SideOnly(Side.CLIENT)
    public void onArmorTick(World world, EntityPlayer entity, ItemStack itemStack) {
    	if (entity instanceof EntityLivingBase)
    	if (entity.inventory.armorItemInSlot(3) != null && entity.inventory.armorItemInSlot(3).getItem() == TechArmor.stoneHelmet
            && entity.inventory.armorItemInSlot(2) != null && entity.inventory.armorItemInSlot(2).getItem() == TechArmor.stoneChestplate
            && entity.inventory.armorItemInSlot(1) != null && entity.inventory.armorItemInSlot(1).getItem() == TechArmor.stoneLeggings
            && entity.inventory.armorItemInSlot(0) != null && entity.inventory.armorItemInSlot(0).getItem() == TechArmor.stoneBoots){
    		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 180, 0, true, false));
    	}
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("Full set gives you Slowness");
    }
}
