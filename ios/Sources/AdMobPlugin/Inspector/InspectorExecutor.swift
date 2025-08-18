import Foundation
import Capacitor
import GoogleMobileAds
import UserMessagingPlatform

class InspectorExecutor: NSObject{

    func showInspector(call: CAPPluginCall){

        MobileAds.shared.presentAdInspector(from: viewController) { error in
         // Error will be non-nil if there was an issue and the inspector was not displayed.
        }

        call.resolve([:])
    }
}