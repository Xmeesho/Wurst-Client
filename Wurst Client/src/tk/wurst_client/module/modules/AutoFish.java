/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.projectile.EntityFishHook;
import tk.wurst_client.module.Category;
import tk.wurst_client.module.Module;

public class AutoFish extends Module
{

	public AutoFish()
	{
		super(
			"AutoFish",
			"Automatically catches fish.",
			0,
			Category.MISC);
	}

	private boolean catching = false;

	@Override
	public void onUpdate()
	{
		if(getToggled()
			&& Minecraft.getMinecraft().thePlayer.fishEntity != null
			&& isHooked(Minecraft.getMinecraft().thePlayer.fishEntity)
			&& !catching)
		{
			catching = true;
			Minecraft.getMinecraft().rightClickMouse();
			new Thread("AutoFish")
			{
				@Override
				public void run()
				{
					try
					{
						Thread.sleep(1000);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					Minecraft.getMinecraft().rightClickMouse();
					catching = false;
				}
			}.start();
		}
	}

	private boolean isHooked(EntityFishHook hook)
	{
		return hook.motionX == 0.0D && hook.motionZ == 0.0D && hook.motionY != 0.0D;
	}
}
