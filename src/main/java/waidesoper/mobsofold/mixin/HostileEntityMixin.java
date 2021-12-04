package waidesoper.mobsofold.mixin;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(HostileEntity.class)
public class HostileEntityMixin {

    /**
     * @author WaideSoper
     * @reason to make mobs spawn in slightly higher light levels, like they used to.
     */
    @Overwrite
    public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.SKY, pos) > random.nextInt(32)) {
            return false;
        }
        if (world.getLightLevel(LightType.BLOCK, pos) > 7) {
            return false;
        }
        int i = world.toServerWorld().isThundering() ? world.getLightLevel(pos, 10) : world.getLightLevel(pos);
        return i <= random.nextInt(8);
    }
}
