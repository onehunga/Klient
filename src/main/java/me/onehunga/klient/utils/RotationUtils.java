package me.onehunga.klient.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;

public class RotationUtils {
	private static MinecraftClient mc = MinecraftClient.getInstance();

	public record Rotation(float pitch, float yaw) {
	}

	public static Rotation getRotations(LivingEntity e) {
		double x = e.getX();
		double z = e.getZ();

		double y = e.getY() + e.getStandingEyeHeight() / 2.0f;
		return getRotationFromPosition(x, y, z);
	}

	public static Rotation getRotationFromPosition(double x, double y, double z) {
		double xDiff = x - mc.player.getX();
		double yDiff = y - mc.player.getY() - 1.2f;
		double zDiff = z - mc.player.getZ();

		double dist = Math.sqrt(xDiff * xDiff + zDiff * zDiff);
		float yaw = (float) (Math.atan2(zDiff, xDiff) * 180.0d / Math.PI) - 90f;
		float pitch = (float) -(Math.atan2(yDiff, dist) * 180d / Math.PI);
		return new Rotation(pitch, yaw);
	}
}
