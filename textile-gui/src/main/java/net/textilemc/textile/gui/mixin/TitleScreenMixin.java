package net.textilemc.textile.gui.mixin;

import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    @Inject(method = "render", at = @At("TAIL"))
    private void addFabricInfo(CallbackInfo ci) {

        String text = "Fabric Loader (TextileMC): " + FabricLoader.getInstance().getAllMods().size() + " mods";
        drawText(this.textureManager, text, 2, 2, 0x808080);
    }
}
