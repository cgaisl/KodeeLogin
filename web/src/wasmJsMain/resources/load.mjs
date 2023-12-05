import { instantiate } from './kodeeLogin.uninstantiated.mjs';

await wasmSetup;

instantiate({ skia: Module['asm'] });
