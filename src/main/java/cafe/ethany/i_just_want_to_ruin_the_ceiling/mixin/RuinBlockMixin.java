package cafe.ethany.i_just_want_to_ruin_the_ceiling.mixin;

import de.dafuqs.spectrum.blocks.decay.RuinBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RuinBlock.class)
public abstract class RuinBlockMixin {

    @Inject(
            method = "shouldCreatePortalFacingUp",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onShouldCreatePortalFacingUp(Level level, BlockPos pos, BlockState state,
                                              CallbackInfoReturnable<BlockState> cir) {
        if (level.dimension() == Level.NETHER) {
            cir.setReturnValue(null);
        }
    }
}