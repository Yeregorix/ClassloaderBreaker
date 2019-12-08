/*
 * Copyright (c) 2019 Hugo Dupanloup (Yeregorix)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.smoofyuniverse.clbreaker;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

import java.net.HttpURLConnection;
import java.net.URL;

@Plugin(id = "classloaderbreaker", name = "ClassloaderBreaker", version = "1.0.1", authors = "Yeregorix")
public class ClassloaderBreaker {

	@Inject
	private Logger logger;

	@Listener
	public void onGamePreInitialization(GamePreInitializationEvent e) {
		this.logger.info("Let's blow Forge classes ..");

		HttpURLConnection co = null;
		try {
			co = (HttpURLConnection) new URL("https://www.google.fr/").openConnection();
			co.setDefaultUseCaches(false);
			co.connect();
		} catch (Exception ex) {
			this.logger.error("Oh no", ex);
		} finally {
			if (co != null)
				co.disconnect();
		}
	}
}
