(ns com.felipegsilva.subs
  (:require
   [refx.alpha :as refx]))

(refx/reg-sub
 :db
 (fn [db _] db))

(refx/reg-sub
 :app/current-route
 (fn [db]
   (:current-route db)))

(refx/reg-sub
 :app/theme
 (fn [db _]
   (:theme db)))
