package org.fountainmc.world;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.world.World;
import org.fountainmc.NMSConverters;
import org.fountainmc.WetServer;
import org.fountainmc.api.event.entity.EntityRemovedEvent;
import org.fountainmc.api.event.entity.EntitySpawnEvent;
import org.fountainmc.entity.WetEntity;
import org.fountainmc.entity.WetEntityPlayer;

public class WorldHookListener implements IWorldEventListener {

    @Override public void notifyBlockUpdate(World var1, BlockPos var2, IBlockState var3, IBlockState var4, int var5) {

    }

    @Override public void notifyLightSet(BlockPos var1) {

    }

    @Override public void markBlockRangeForRenderUpdate(int var1, int var2, int var3, int var4, int var5, int var6) {

    }

    @Override
    public void playSoundToAllNearExcept(@Nullable EntityPlayer var1, SoundEvent var2, SoundCategory var3, double var4, double var6, double var8,
            float var10, float var11) {

    }

    @Override public void playRecord(SoundEvent var1, BlockPos var2) {

    }

    @Override
    public void spawnParticle(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {

    }

    @Override public void onEntityAdded(Entity var1) {
        WetEntity entity = convert(var1);
        WetServer.getInstance().getPluginManager().fireEvent(new EntitySpawnEvent(entity, NMSConverters.toFountainLocation(var1.getEntityWorld(),
                var1.getPosition())));
    }

    private WetEntity convert(Entity entity) {
        WetEntity wetEntity = new WetEntityPlayer(entity);
        if (entity instanceof EntityPlayer) {
            wetEntity = new WetEntityPlayer(entity);
        }
        return wetEntity;
    }

    @Override public void onEntityRemoved(Entity var1) {
        WetEntity entity = convert(var1);
        WetServer.getInstance().getPluginManager().fireEvent(new EntityRemovedEvent(entity, NMSConverters.toFountainLocation(var1.getEntityWorld(),
                var1.getPosition())));
    }

    @Override public void broadcastSound(int var1, BlockPos var2, int var3) {

    }

    @Override public void playEvent(EntityPlayer var1, int var2, BlockPos var3, int var4) {

    }

    @Override public void sendBlockBreakProgress(int var1, BlockPos var2, int var3) {

    }
}
