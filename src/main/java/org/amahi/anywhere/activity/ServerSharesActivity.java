/*
 * Copyright (c) 2014 Amahi
 *
 * This file is part of Amahi.
 *
 * Amahi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Amahi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Amahi. If not, see <http ://www.gnu.org/licenses/>.
 */

package org.amahi.anywhere.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import org.amahi.anywhere.fragment.ServerSharesFragment;
import org.amahi.anywhere.server.model.Server;
import org.amahi.anywhere.util.Fragments;

public class ServerSharesActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setUpTitle();
		setUpFragment();
	}

	private void setUpTitle() {
		getActionBar().setSubtitle(getServer().getName());
	}

	private Server getServer() {
		return getIntent().getParcelableExtra(Fragments.Arguments.SERVER);
	}

	private void setUpFragment() {
		Fragments.Operator.at(this).set(buildFragment(), android.R.id.content);
	}

	private Fragment buildFragment() {
		return ServerSharesFragment.newInstance(getServer());
	}
}