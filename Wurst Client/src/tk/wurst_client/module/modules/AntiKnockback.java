/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.module.modules;

import tk.wurst_client.module.Category;
import tk.wurst_client.module.Module;

public class AntiKnockback extends Module
{
	public AntiKnockback()
	{
		super(
			"AntiKnockback",
			"Protects you from getting pushed by players, mobs and\n"
				+ "fluids.",
				0,
				Category.COMBAT);
	}
}
