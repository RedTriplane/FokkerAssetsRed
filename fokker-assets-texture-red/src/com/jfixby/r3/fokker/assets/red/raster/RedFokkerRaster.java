
package com.jfixby.r3.fokker.assets.red.raster;

import com.jfixby.r3.fokker.assets.api.raster.FokkerRasterComponent;
import com.jfixby.r3.fokker.assets.api.raster.FokkerRasterHandler;
import com.jfixby.r3.fokker.assets.api.raster.FokkerRasterPackageReader;
import com.jfixby.scarabei.api.assets.ID;
import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.Map;

public class RedFokkerRaster implements FokkerRasterComponent {

	final Map<ID, FokkerRasterHandler> registry = Collections.newMap();

	public void register (final ID raster_id, final FokkerRasterHandler data) {
		this.registry.put(raster_id, data);
	}

	final FokkerTextureLoader loader = new FokkerTextureLoader(this);

	@Override
	public FokkerRasterPackageReader packageReader () {
		return this.loader;
	}

	@Override
	public FokkerRasterHandler obtain (final ID assetID) {
		return this.registry.get(assetID);
	}

}
