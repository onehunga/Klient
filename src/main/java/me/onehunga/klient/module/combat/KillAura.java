package me.onehunga.klient.module.combat;

import com.google.common.collect.Lists;
import me.onehunga.klient.module.ModuleBase;
import me.onehunga.klient.module.ModuleCategory;
import me.onehunga.klient.module.settings.BoolSetting;
import me.onehunga.klient.utils.RotationUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class KillAura extends ModuleBase {
	private int range = 3;
	private BoolSetting cooldown = new BoolSetting("Cooldown", false);

	public KillAura() {
		super(ModuleCategory.COMBAT, "KillAura", "legit killaura", GLFW.GLFW_KEY_R, false);

		addSettings(cooldown);
	}

	@Override
	public void onTick() {
		// filter all entities
		List<LivingEntity> targets = Lists.<LivingEntity>newArrayList();
		for(Entity e : mc.world.getEntities()) {
			if(e instanceof LivingEntity && e != mc.player && mc.player.distanceTo(e) <= this.range) {
				targets.add((LivingEntity) e);
			}
		}
		targets = targets.stream().filter(LivingEntity::isAlive).toList();

		if(targets.size() == 0) return;

		RotationUtils.Rotation rotation = RotationUtils.getRotations(targets.get(0));
		mc.player.setYaw(rotation.yaw());
		mc.player.setPitch(rotation.pitch());

		if(!cooldown.getValue() || mc.player.getAttackCooldownProgress(0.5f) == 1) {
			mc.interactionManager.attackEntity(mc.player, targets.get(0));
			mc.player.swingHand(Hand.MAIN_HAND);
		}

	}
}
