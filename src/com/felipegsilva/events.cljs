(ns com.felipegsilva.events
  (:require
   [refx.alpha :as refx]))

(refx/reg-event-fx
 :app/initialize-db
 (fn [db _]
   {:db (assoc db
               :current-route nil
               :theme "dark")}))

(refx/reg-event-fx
 :app/set-theme
 (fn [db [_ theme]]
   {:db (assoc db :theme theme)}))

(refx/reg-event-fx
 :app/set-route
 (fn [db [_ route]]
   {:db (assoc db :current-route route)}))
