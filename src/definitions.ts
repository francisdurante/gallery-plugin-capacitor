declare module "@capacitor/core" {
  interface PluginRegistry {
    GalleryPlugin: GalleryPluginPlugin;
  }
}

export interface GalleryPluginPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
}
