import Foundation
import Capacitor
import GoogleMobileAds
import UserMessagingPlatform

class InspectorExecutor: NSObject{

    func showInspector(call: CAPPluginCall, viewController: UIViewController){

        MobileAds.shared.presentAdInspector(from: viewController) { error in
        call.reject("Failed to present Ad Inspector", error?.localizedDescription);
        }

        call.resolve([:])
    }
}