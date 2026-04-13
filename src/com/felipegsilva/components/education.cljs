(ns com.felipegsilva.components.education
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]))

(def edu-data
  [{:degree "Bachelor's in Computer Science"
    :institution "Unesp Rio Preto"
    :period "Expected: 2026"
    :description "Thesis: \"Exploration of neural radiance fields as a data augmentation strategy: application in histopathology.\" Evaluation of hybrid architectures (GAN-NeRF) to mitigate medical data scarcity, analyzing visual fidelity and impact on predictive models."}
   {:degree "Graduate Research (In Progress)"
    :institution "Unesp Rio Preto"
    :period "March 2026 - June 2026"
    :description "\"An Analysis of CNN and ViT-based Hybrid NeRFs on Sparse View Datasets.\" Quantifying trade-offs between global generalization (Transformers) and local processing efficiency (Convolutions) for 3D rendering under hardware constraints (PSNR, SSIM, VRAM, FPS)."}
   {:degree "Scientific Initiation in Image Processing"
    :institution "Unesp Rio Preto"
    :period "October 2025 - October 2026"
    :description "\"Investigation of hybrid approaches for data augmentation in histopathological image datasets.\" Applied research at the intersection of computer graphics and machine learning."}
   {:degree "Technical Degree in Internet Computing"
    :institution "Etec Fernandopolis"
    :period "2020 - 2022"
    :description nil}])

(defnc edu-item [{:keys [degree institution period description is-dark?]}]
  (d/div {:class "mb-7"}
         (d/div {:class "flex flex-col md:flex-row md:justify-between md:items-baseline mb-1 gap-1"}
                (d/div {:class "flex items-center gap-2 flex-wrap"}
                       (d/span {:class "font-bold"} degree)
                       (d/span {:class "text-gray-500 mx-1"} "|")
                       (d/span {:class (if is-dark? "text-gray-400" "text-gray-600")} institution))
                (d/span {:class "text-sm text-gray-500 flex-shrink-0"} period))
         (when description
           (d/p {:class (str "text-sm leading-relaxed italic "
                             (if is-dark? "text-gray-400" "text-gray-500"))}
                description))))

(defnc education [{:keys [is-dark?]}]
  (d/section {:id "education" :class "w-full py-12"}
             (d/h2 {:class "text-2xl font-bold mb-2"} "Education & Research")
             (d/div {:class (str "border-b mb-8 " (if is-dark? "border-gray-700" "border-gray-200"))})
             (map (fn [{:keys [degree institution period description]}]
                    ($ edu-item {:key degree
                                 :degree degree
                                 :institution institution
                                 :period period
                                 :description description
                                 :is-dark? is-dark?}))
                  edu-data)))
