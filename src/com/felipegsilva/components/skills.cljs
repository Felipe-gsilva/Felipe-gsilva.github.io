(ns com.felipegsilva.components.skills
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]))

(defnc skill-row [{:keys [label items is-dark?]}]
  (d/div {:class "mb-4 flex flex-col md:flex-row md:gap-6"}
         (d/span {:class (str "text-sm font-bold flex-shrink-0 md:w-52 mb-1 md:mb-0 "
                              (if is-dark? "text-gray-300" "text-gray-700"))}
                 label)
         (d/span {:class (str "text-sm " (if is-dark? "text-gray-400" "text-gray-600"))}
                 items)))

(defnc skills [{:keys [is-dark?]}]
  (d/section {:id "skills" :class "w-full py-12 pb-20"}
             (d/h2 {:class "text-2xl font-bold mb-2"} "Skills")
             (d/div {:class (str "border-b mb-8 " (if is-dark? "border-gray-700" "border-gray-200"))})

             ($ skill-row {:label "Programming Languages"
                           :items "C, Python, C++, Rust, JavaScript / TypeScript, Clojure, Java"
                           :is-dark? is-dark?})

             ($ skill-row {:label "Backend & Systems"
                           :items "API Design, Distributed Systems, High Performance Computing, Concurrency"
                           :is-dark? is-dark?})

             ($ skill-row {:label "Infrastructure & Data"
                           :items "Linux, Docker, PostgreSQL, Redis, Supabase"
                           :is-dark? is-dark?})

             ($ skill-row {:label "Graphics & ML"
                           :items "Vulkan, OpenGL, PyTorch, OpenCV, Vector Search (HNSW)"
                           :is-dark? is-dark?})

             (d/div {:class (str "my-6 border-t " (if is-dark? "border-gray-800" "border-gray-200"))})

             (d/div {:class "mb-4"}
                    (d/span {:class (str "text-sm font-bold "
                                         (if is-dark? "text-gray-300" "text-gray-700"))}
                            "Community  ")
                    (d/span {:class (str "text-sm " (if is-dark? "text-gray-400" "text-gray-600"))}
                            "Co-creator and maintainer of ")
                    (d/a {:href "https://codingferpa.org"
                          :target "_blank"
                          :class "text-sm underline hover:text-yellow-600 transition-all duration-75"}
                         "codingferpa")
                    (d/span {:class (str "text-sm " (if is-dark? "text-gray-400" "text-gray-600"))}
                            " (2024 - Present) - organization dedicated to democratizing tech education through talks, open-source materials, and meetups."))

             ($ skill-row {:label "Human Languages"
                           :items "Portuguese (Native), English (Advanced)"
                           :is-dark? is-dark?})))
