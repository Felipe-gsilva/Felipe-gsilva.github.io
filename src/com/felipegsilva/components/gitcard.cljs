(ns com.felipegsilva.components.gitcard
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc git-card [{:keys [name desc img_url repo_url]}]
  (d/div {:class "px-6 py-4 border rounded-lg"}
         (d/a {:class "text-sm select-none"
               :href repo_url}  name)))

(defnc git-projects-roulette []
  (d/div {:class "w-max flex justify-center items-start space-x-4"}
         (for [i (range 5)]
           ($ git-card {:name (str "project " i)}))))
