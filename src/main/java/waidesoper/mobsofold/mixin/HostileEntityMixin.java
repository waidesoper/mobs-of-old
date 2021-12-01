package waidesoper.mobsofold.mixin;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.Random;

@Mixin(HostileEntity.class)
public class HostileEntityMixin {

    /**
     * @author WaideSoper
     */
    @Overwrite
    public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.SKY, pos) > random.nextInt(32)) {
            return false;
        }
        if (world.getLightLevel(LightType.BLOCK, pos) < 8) {
            return false;
        }
        int i = world.toServerWorld().isThundering() ? world.getLightLevel(pos, 10) : world.getLightLevel(pos);
        return i <= random.nextInt(8);
    }
}
