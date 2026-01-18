# LiquidGlass for iOS Compose


<img height="100" align="left" src="https://github.com/user-attachments/assets/07fed02d-461d-4157-a61e-1eaede39c9b9"/>


This project demonstrates how to use **UIKit Interop** to integrate **LiquidGlass** UI components into a **Compose Multiplatform** application on iOS.








> Another question is how you’re going to combine LiquidGlass and Material You…

## Samples
- [ ] Button
- [ ] Switch
- [ ] BottomBar

## Known Issues and Workarounds

### GlassButton problems and workarounds

#### 1. Button clipping on resize
When the button is resized for animate interactions, the glass background may be clipped.

**Workaround:**
* Add internal padding to the container view

#### 2. Shadow clipping
`glassButtonConfiguration()` adds a system shadow that may be clipped or visually inconsistent inside Compose layouts.

  **Workaround:**
  * Remove the shadow =)
  
  ```kotlin
  button.layer.masksToBounds = true // Removes shadow added by glassButtonConfiguration
  ```

> [!WARNING]
> Removing the shadow slightly deviates from the native LiquidGlass appearance. 
> Additionally, without the shadow the button may be hard to see on a white background, so it is recommended to use a white background with a subtle tint or shade to maintain visibility.

## Result
<p align="center">
<img width="200" src="https://github.com/user-attachments/assets/07fed02d-461d-4157-a61e-1eaede39c9b9"/>
</p>
