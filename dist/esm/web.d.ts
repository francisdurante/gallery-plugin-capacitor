import { WebPlugin } from '@capacitor/core';
import { GalleryPluginPlugin } from './definitions';
export declare class GalleryPluginWeb extends WebPlugin implements GalleryPluginPlugin {
    constructor();
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
declare const GalleryPlugin: GalleryPluginWeb;
export { GalleryPlugin };
