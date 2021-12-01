package waidesoper.mobsofold.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpawnHelper.class)
public class SpawnHelperMixin {
    /**
     * @author WaideSoper
     */
    private static BlockPos getRandomPosInChunkSection(World world, WorldChunk chunk) {
        ChunkPos chunkPos = chunk.getPos();
        int i = chunkPos.getStartX() + world.random.nextInt(16);
        int j = chunkPos.getStartZ() + world.random.nextInt(16);
        int k = chunk.sampleHeightmap(Heightmap.Type.WORLD_SURFACE, i, j) + 1;
        int l = MathHelper.nextBetween(world.random, world.getBottomY(), k);
        return new BlockPos(i, k-l, j);
    }
}
